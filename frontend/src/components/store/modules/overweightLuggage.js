import axios from "axios";

export default {
    state: {
        overweightLuggageList: [],
        overweightLuggage: {
            id: '',
            overweight: '',
            overweightSerchage: '',
            luggage: ''
        }
    },
    mutations: {
        setOverweightLuggageList(state, overweightLuggageList) {
            state.overweightLuggageList = overweightLuggageList
        },
        setOverweightLuggage(state, newOverweightLuggage) {
            state.overweightLuggage = {...state.overweightLuggage, ...newOverweightLuggage};
        },
        setOverweightLuggageOverweight(state, overweight) {
            state.overweightLuggage = {...state.overweightLuggage, overweight: overweight}
        },
        setOverweightLuggageSerchage(state, overweightSerchage) {
            state.overweightLuggage = {...state.overweightLuggage, overweightSerchage: overweightSerchage};
        },
        setOverweightLuggageLuggage(state, luggage) {
            state.overweightLuggage = {...state.overweightLuggage, luggage: luggage};
        },
    },
    getters: {
        overweightLuggageList(state) {
            return state.overweightLuggageList
        },
        overweightLuggageCount(state) {
            return state.overweightLuggageList.length
        }
    },
    actions: {
        async fetchOverweightLuggage({commit}) {
            await axios({
                method: 'GET',
                url: `http://localhost:8080/overweightluggage`,
                data: {},
                headers: {},
            }).then(response => {
                commit('setOverweightLuggageList', response.data)
                console.log(response.data)
            })
        },
        async addOverweightLuggage({commit}, {overweight, overweightSerchage, luggageId}) {
            await axios({
                method: 'POST',
                url: `http://localhost:8080/overweightluggage`,
                data: {
                    'overweight': overweight,
                    'overweightSerchage': overweightSerchage,
                    'luggage': {
                        'id': luggageId
                    }
                },
                headers: {},
            }).then(response => {
                commit('setOverweightLuggage', response.data)
                console.log(response.data)
            })
        },
        async editOverweightLuggage({commit}, {id, overweight, overweightSerchage, luggageId}) {
            await axios({
                method: 'POST',
                url: `http://localhost:8080/overweightluggage`,
                data: {
                    'id': id,
                    'overweight': overweight,
                    'overweightSerchage': overweightSerchage,
                    'luggage': {
                        'id': luggageId
                    }
                },
                headers: {},
            }).then(response => {
                commit('setOverweightLuggage', response.data)
            })
        },
    },
}