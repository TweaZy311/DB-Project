import axios from "axios";

export default {
    state: {
        positionList: [],
        position: {
            id: '',
            name: '',
        }
    },
    mutations: {
        setPositionList(state, positionList) {
            state.positionList = positionList
        },
        setPosition(state, newPosition) {
            state.position = {...state.position, ...newPosition};
        },
        setPositionName(state, name) {
            state.position = {...state.position, name: name}
        },
    },
    getters: {
        positionList(state) {
            return state.positionList
        },
        positionCount(state) {
            return state.positionList.length
        }
    },
    actions: {
        async fetchPosition({commit}) {
            await axios({
                method: 'GET',
                url: `http://localhost:8080/position`,
                data: {},
                headers: {},
            }).then(response => {
                commit('setPositionList', response.data)
                console.log(response.data)
            })
        },
        async addPosition({commit}, {name}) {
            await axios({
                method: 'POST',
                url: `http://localhost:8080/position`,
                data: {
                    'name': name,
                },
                headers: {},
            }).then(response => {
                commit('setPosition', response.data)
                console.log(response.data)
            })
        },
        async editPosition({commit}, {id, name}) {
            await axios({
                method: 'POST',
                url: `http://localhost:8080/position`,
                data: {
                    'id': id,
                    'name': name,
                },
                headers: {},
            }).then(response => {
                commit('setPosition', response.data)
            })
        },
    },
}