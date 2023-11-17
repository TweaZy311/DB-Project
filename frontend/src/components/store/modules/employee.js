import axios from "axios";



export default {
    state: {
        employeeList: [],
        employee: {
            id: '',
            salary: '',
            person: '',
            department: '',
            position: ''
        }
    },
    mutations: {
        setEmployeeList(state, employeeList) {
            state.employeeList = employeeList
        },
        setEmployee(state, newEmployee) {
            state.employee = {...state.employee, ...newEmployee};
        },
        setEmployeeSalary(state, salary) {
            state.employee = {...state.employee, salary: salary}
        },
        setEmployeePerson(state, person) {
            state.employee = {...state.employee, person: person};
        },
        setEmployeeDepartment(state, department) {
            state.employee = {...state.employee, department: department};
        },
        setEmployeePosition(state, position) {
            state.employee = {...state.employee, position: position};
        },
    },
    getters: {
        employeeList(state) {
            return state.employeeList
        },
        employeeCount(state) {
            return state.employeeList.length
        }
    },
    actions: {
        async fetchEmployee({commit}) {
            await axios({
                method: 'GET',
                url: `http://localhost:8080/employee`,
                data: {},
                headers: {},
            }).then(response => {
                commit('setEmployeeList', response.data)
                console.log(response.data)
            })
        },
        async addEmployee({commit}, {salary, personId, departmentId, positionId}) {
            console.log({
                'salary': salary,
                'person': {
                    'id': personId
                },
                'department': {
                    'id': departmentId
                },
                'position': {
                    'id': positionId
                }
            },)
            await axios({
                method: 'POST',
                url: `http://localhost:8080/employee`,
                data: {
                    'salary': salary,
                    'person': {
                        'id': personId
                    },
                    'department': {
                        'id': departmentId
                    },
                    'position': {
                        'id': positionId
                    }
                },
                headers: {},
            }).then(response => {
                commit('setEmployee', response.data)
                console.log(response.data)
            })
        },
        async editEmployee({commit}, {id, salary, personId, departmentId, positionId}) {
            await axios({
                method: 'POST',
                url: `http://localhost:8080/employee`,
                data: {
                    'id': id,
                    'salary': salary,
                    'person': {
                        'id': personId
                    },
                    'department': {
                        'id': departmentId
                    },
                    'position': {
                        'id': positionId
                    }
                },
                headers: {},
            }).then(response => {
                commit('setEmployee', response.data)
            })
        },
    },
}