import axios from "axios";

function formatDate(time) {
    const date = new Date(time);

    const year = date.getFullYear();
    const month = (date.getMonth() + 1).toString().padStart(2, '0');
    const day = date.getDate().toString().padStart(2, '0');
    const hours = date.getHours().toString().padStart(2, '0');
    const minutes = date.getMinutes().toString().padStart(2, '0');

    return `${year}-${month}-${day}T${hours}:${minutes}`;
}

export default {
    state: {
        flightList: [],
        flight: {
            id: '',
            departurePoint: '',
            departureTime: '',
            destination: '',
            employee: ''
        }
    },
    mutations: {
        setFlightList(state, flightList) {
            state.flightList = flightList.map(item => {
                    return {
                        ...item, departureTime: formatDate(item.departureTime)
                    }
                }
            )
        },
        setFlight(state, newFlight) {
            state.flight = {...state.flight, ...newFlight};
        },
        setFlightDeparturePoint(state, departurePoint) {
            state.flight = {...state.flight, departurePoint: departurePoint}
        },
        setFlightDepartureTime(state, departureTime) {
            state.flight = {...state.flight, departureTime: departureTime};
        },
        setFlightDestination(state, destination) {
            state.flight = {...state.flight, destination: destination};
        },
        setFlightEmployee(state, employee) {
            state.flight = {...state.flight, employee: employee};
        },
    },
    getters: {
        flightList(state) {
            return state.flightList
        },
        flightCount(state) {
            return state.flightList.length
        }
    },
    actions: {
        async fetchFlight({commit}) {
            await axios({
                method: 'GET',
                url: `http://localhost:8080/flight`,
                data: {},
                headers: {},
            }).then(response => {
                commit('setFlightList', response.data)
                console.log(response.data)
                console.log(formatDate(new Date(response.data[0].departureTime)))
            })
        },
        async addFlight({commit}, {departurePoint, departureTime, destination, employeeId}) {
            console.log({
                'departurePoint': departurePoint,
                'departureTime': departureTime,
                'destination': destination,
                'employee': {
                    'id': employeeId
                }
            })
            await axios({
                method: 'POST',
                url: `http://localhost:8080/flight`,
                data: {
                    'departurePoint': departurePoint,
                    'departureTime': departureTime,
                    'destination': destination,
                    'employee': {
                        'id': employeeId
                    }
                },
                headers: {},
            }).then(response => {
                commit('setFlight', response.data)
                console.log(response.data)
            })
        },
        async editFlight({commit}, {id, departurePoint, departureTime, destination, employeeId}) {
            await axios({
                method: 'POST',
                url: `http://localhost:8080/flight`,
                data: {
                    'id': id,
                    'departurePoint': departurePoint,
                    'departureTime': departureTime,
                    'destination': destination,
                    'employee': {
                        'id': employeeId
                    }
                },
                headers: {},
            }).then(response => {
                commit('setFlight', response.data)
            })
        },
    },
}