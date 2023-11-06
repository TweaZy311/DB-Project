import axios from "axios";
export default {
    actions: {
        async fetchPerson({commit}) {
            await axios({
                method: 'GET',
                url: `http://localhost:8080/person`,
                data: {},
                headers: {},
            }).then(response => {
                commit('updatePerson', response.data)
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
    },
    mutations: {
        updatePerson(state, personList){
            state.personList = personList
        },
        setPerson(state, newPerson){
            state.person = newPerson
        }
    },
    state: {
        personList: [],
        person: {
            date_of_birth: '',
            name: '',
            second_name: '',
            last_name: '',
        },
    },
    getters: {
        personList(state){
            return state.personList
        },
        personCount(state){
            return state.personList.length
        }
    }
}