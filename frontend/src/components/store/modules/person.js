import axios from "axios";

function formatDate(date) {
    const year = date.getFullYear();
    const month = (date.getMonth() + 1).toString().padStart(2, '0');
    const day = date.getDate().toString().padStart(2, '0');
    return `${year}-${month}-${day}`;
}

export default {
    state: {
        personList: [],
        person: {
            id: '',
            date_of_birth: '',
            name: '',
            second_name: '',
            last_name: '',
        },
    },
    mutations: {
        setPersonList(state, personList) {
            state.personList = personList.map(item => {
                return {
                    ...item, dateOfBirth: formatDate(new Date(item.dateOfBirth[0],
                        item.dateOfBirth[1] - 1,
                        item.dateOfBirth[2]))
                }
            })
        },
        setPerson(state, newPerson) {
            state.person = { ...state.person, ...newPerson };
        },
        setPersonName(state, name) {
            state.person = { ...state.person, name };
        },
        setPersonSecondName(state, secondName) {
            state.person = { ...state.person, second_name: secondName };
        },
        setPersonLastName(state, lastName) {
            state.person = { ...state.person, last_name: lastName };
        },
        setPersonBirth(state, birth) {
            state.person = { ...state.person, date_of_birth: birth };
        },

    },
    getters: {
        personList(state) {
            return state.personList
        },
        personCount(state) {
            return state.personList.length
        }
    },
    actions: {
        async fetchPerson({commit}) {
            await axios({
                method: 'GET',
                url: `http://localhost:8080/person`,
                data: {},
                headers: {},
            }).then(response => {
                commit('setPersonList', response.data)
            })
        },
        async addPerson({commit}, {dateOfBirth, name, secondName, lastName}) {
            await axios({
                method: 'POST',
                url: `http://localhost:8080/person`,
                data: {
                    'dateOfBirth': dateOfBirth,
                    'name': name,
                    'secondName': secondName,
                    'lastName': lastName,
                },
                headers: {},
            }).then(response => {
                commit('setPerson', response.data)
            })
        },
        async editPerson({commit}, {id, dateOfBirth, name, secondName, lastName}) {
            await axios({
                method: 'POST',
                url: `http://localhost:8080/person`,
                data: {
                    'id': id,
                    'dateOfBirth': dateOfBirth,
                    'name': name,
                    'secondName': secondName,
                    'lastName': lastName,
                },
                headers: {},
            }).then(response => {
                commit('setPerson', response.data)
            })
        }
    }
}