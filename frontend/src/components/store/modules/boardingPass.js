import axios from "axios";

export default {
    state: {
        boardingPassList: [],
        boardingPass: {
            id: {
                flight: '',
                passenger: ''
            },
            seatNumber: ''
        }
    },
    mutations: {
        setBoardingPassList(state, boardingPassList) {
            state.boardingPassList = boardingPassList
        },
        setBoardingPass(state, newBoardingPass) {
            state.boardingPass = {...state.boardingPass, ...newBoardingPass};
        },
        setBoardingPassSeatNumber(state, seatNumber) {
            state.boardingPass = {...state.boardingPass, seatNumber: seatNumber};
        },
        setBoardingPassId(state, id) {
            state.boardingPass = {...state.boardingPass, id: id}
        },
    },
    getters: {
        boardingPassList(state) {
            return state.boardingPassList
        },
        boardingPassCount(state) {
            return state.boardingPassList.length
        }
    },
    actions: {
        async fetchBoardingPass({commit}) {
            await axios({
                method: 'GET',
                url: `http://localhost:8080/boardingpass`,
                data: {},
                headers: {},
            }).then(response => {
                commit('setBoardingPassList', response.data)
                console.log(response.data)
            })
        },
        async addBoardingPass({commit}, {idFlight, idPassenger, seatNumber}) {
            const id = {
                flight: {
                    id: idFlight,
                },
                passenger: {
                    id: idPassenger,
                }
            }
            await axios({
                method: 'POST',
                url: `http://localhost:8080/boardingpass`,
                data: {
                    'id': id,
                    'seatNumber': seatNumber,
                },
                headers: {},
            }).then(response => {
                commit('setBoardingPass', response.data)
                console.log(response.data)
            })
        },
        async editBoardingPass({commit}, {idFlight, idPassenger, seatNumber}) {
            const id = {
                flight: {
                    id: idFlight,
                },
                passenger: {
                    id: idPassenger,
                }
            }
            await axios({
                method: 'POST',
                url: `http://localhost:8080/boardingpass`,
                data: {
                    'id': id,
                    'seatNumber': seatNumber,
                },
                headers: {},
            }).then(response => {
                commit('setBoardingPass', response.data)
            })
        },
    },
}