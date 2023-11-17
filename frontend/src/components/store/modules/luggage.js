import axios from "axios";

export default {
    state: {
        luggageList: [],
        luggage: {
            id: '',
            size: '',
            weight: '',
            passenger: ''
        }
    },
    mutations: {
        setLuggageList(state, luggageList) {
            state.luggageList = luggageList
        },
        setLuggage(state, newLuggage) {
            state.luggage = {...state.luggage, ...newLuggage};
        },
        setLuggageSize(state, size) {
            state.luggage = {...state.luggage, size: size}
        },
        setLuggageWeight(state, weight) {
            state.luggage = {...state.luggage, weight: weight};
        },
        setLuggagePassenger(state, passenger) {
            state.luggage = {...state.luggage, passenger: passenger};
        },
    },
    getters: {
        luggageList(state) {
            return state.luggageList
        },
        luggageCount(state) {
            return state.luggageList.length
        }
    },
    actions: {
        async fetchLuggage({commit}) {
            await axios({
                method: 'GET',
                url: `http://localhost:8080/luggage`,
                data: {},
                headers: {},
            }).then(response => {
                commit('setLuggageList', response.data)
                console.log(response.data)
            })
        },
        async addLuggage({commit}, {size, weight, passengerId}) {
            await axios({
                method: 'POST',
                url: `http://localhost:8080/luggage`,
                data: {
                    'size': size,
                    'weight': weight,
                    'passenger': {
                        'id': passengerId
                    }
                },
                headers: {},
            }).then(response => {
                commit('setLuggage', response.data)
                console.log(response.data)
            })
        },
        async editLuggage({commit}, {id, size, weight, passengerId}) {
            await axios({
                method: 'POST',
                url: `http://localhost:8080/luggage`,
                data: {
                    'id': id,
                    'size': size,
                    'weight': weight,
                    'passenger': {
                        'id': passengerId
                    }
                },
                headers: {},
            }).then(response => {
                commit('setLuggage', response.data)
            })
        },
    },
}