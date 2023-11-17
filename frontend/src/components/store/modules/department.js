import axios from "axios";

export default {
    state: {
        departmentList: [],
        department: {
            id: '',
            address: '',
            name: '',
        }
    },
    mutations: {
        setDepartmentList(state, departmentList) {
            state.departmentList = departmentList
        },
        setDepartment(state, newDepartment) {
            state.department = {...state.department, ...newDepartment};
        },
        setDepartmentAddress(state, address) {
            state.department = {...state.department, address: address};
        },
        setDepartmentName(state, name) {
            state.department = {...state.department, name: name}
        },
    },
    getters: {
        departmentList(state) {
            return state.departmentList
        },
        departmentCount(state) {
            return state.departmentList.length
        }
    },
    actions: {
        async fetchDepartment({commit}) {
            await axios({
                method: 'GET',
                url: `http://localhost:8080/department`,
                data: {},
                headers: {},
            }).then(response => {
                commit('setDepartmentList', response.data)
                console.log(response.data)
            })
        },
        async addDepartment({commit}, {address, name}) {
            await axios({
                method: 'POST',
                url: `http://localhost:8080/department`,
                data: {
                    'address': address,
                    'name': name,
                },
                headers: {},
            }).then(response => {
                commit('setDepartment', response.data)
                console.log(response.data)
            })
        },
        async editDepartment({commit}, {id, address, name}) {
            await axios({
                method: 'POST',
                url: `http://localhost:8080/department`,
                data: {
                    'id': id,
                    'address': address,
                    'name': name,
                },
                headers: {},
            }).then(response => {
                commit('setDepartment', response.data)
            })
        },
    },
}