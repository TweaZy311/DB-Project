import axios from "axios";

export default {
    state: {
        passengerList: [],
        passenger: {
            id: '',
            registrationDate: '',
            passport: '',
            person: ''
        }
    },
    mutations: {
        setPassengerList(state, passengerList) {
            state.passengerList = passengerList
        },
        setPassenger(state, newEmployee) {
            state.passenger = {...state.passenger, ...newEmployee};
        },
        setPassengerRegistrationDate(state, registrationDate) {
            state.passenger = {...state.passenger, registrationDate: registrationDate}
        },
        setPassengerPassport(state, passport) {
            state.passenger = {...state.passenger, passport: passport};
        },
        setPassengerPerson(state, person) {
            state.passenger = {...state.passenger, person: person};
        },
    },
    getters: {
        passengerList(state) {
            return state.passengerList
        },
        passengerCount(state) {
            return state.passengerList.length
        }
    },
    actions: {
        async fetchPassenger({commit}) {
            await axios({
                method: 'GET',
                url: `http://localhost:8080/passenger`,
                data: {},
                headers: {},
            }).then(response => {
                commit('setPassengerList', response.data)
                console.log(response.data)
            })
        },
        async addPassenger({commit}, {registrationDate, passportId, personId}) {
            await axios({
                method: 'POST',
                url: `http://localhost:8080/passenger`,
                data: {
                    'person': {
                        'id': personId
                    },
                    'registrationDate': registrationDate,
                    'passport': {
                        'id': passportId
                    }
                },
                headers: {},
            }).then(response => {
                commit('setPassenger', response.data)
                console.log(response.data)
            })
        },
        async editPassenger({commit}, {id, registrationDate, passportId, personId}) {
            await axios({
                method: 'POST',
                url: `http://localhost:8080/passenger`,
                data: {
                    'id': id,
                    'person': {
                        'id': personId
                    },
                    'registrationDate': registrationDate,
                    'passport': {
                        'id': passportId
                    }
                },
                headers: {},
            }).then(response => {
                commit('setPassenger', response.data)
            })
        },
    },
}