import axios from "axios";

function formatDate(date) {
    const year = date.getFullYear();
    const month = (date.getMonth() + 1).toString().padStart(2, '0');
    const day = date.getDate().toString().padStart(2, '0');
    return `${year}-${month}-${day}`;
}

export default {
    state: {
        passportList: [],
        passport: {
            id: '',
            number: '',
            serial: '',
            validityPeriod: ''
        }
    },
    mutations: {
        setPassportList(state, passportList) {
            state.passportList = passportList.map(item => {
                return {
                    ...item, validityPeriod: formatDate(new Date(item.validityPeriod[0],
                        item.validityPeriod[1] - 1,
                        item.validityPeriod[2]))
                }
            })
        },
        setPassport(state, newPassport) {
            state.passport = {...state.passport, ...newPassport};
        },
        setPassportNumber(state, number) {
            state.passport = {...state.passport, number: number}
        },
        setPassportSerial(state, serial) {
            state.passport = {...state.passport, serial: serial}
        },
        setPassportValidityPeriod(state, validityPeriod) {
            state.passport = {...state.passport, validityPeriod: validityPeriod}
        }
    },
    getters: {
        passportList(state) {
            return state.passportList
        },
        passportCount(state) {
            return state.passportList.length
        }
    },
    actions: {
        async fetchPassport({commit}) {
            await axios({
                method: 'GET',
                url: `http://localhost:8080/passport`,
                data: {},
                headers: {},
            }).then(response => {
                commit('setPassportList', response.data)
                console.log(response.data)
            })
        },
        async addPassport({commit}, {number, serial, validityPeriod}) {
            await axios({
                method: 'POST',
                url: `http://localhost:8080/passport`,
                data: {
                    'number': number,
                    'serial': serial,
                    'validityPeriod': validityPeriod,
                },
                headers: {},
            }).then(response => {
                commit('setPassport', response.data)
                console.log(response.data)
            })
        },
        async editPassport({commit}, {id, number, serial, validityPeriod}) {
            await axios({
                method: 'POST',
                url: `http://localhost:8080/position`,
                data: {
                    'id': id,
                    'number': number,
                    'serial': serial,
                    'validityPeriod': validityPeriod,
                },
                headers: {},
            }).then(response => {
                commit('setPassport', response.data)
            })
        },
    },
}