<template>
  EMPLOYEE
    <div class="edit" v-if="show">
        <div class="input-group mb-3"
             v-for="employeeFromList in employeeList" v-bind:key="employeeFromList.id">
            <div class="input-group-prepend">
            </div>
            <input type="number" v-model="employeeFromList.id" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="number" v-model="employeeFromList.person.id" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="number" v-model="employeeFromList.position.id" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="number" v-model="employeeFromList.department.id" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="number" v-model="employeeFromList.salary" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <button @click="edit(employeeFromList)">Изменить</button>
        </div>
    </div>
    <div class="create" v-else>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
            </div>
            <my-input type="number" placeholder="Зарплата"
                      :model-value="employee.salary"
                      @update:model-value="setEmployeeSalary"/>
            <my-input type="number" placeholder="Должность"
                      :model-value="employee.position.id"
                      @update:model-value="updatePositionId"/>
            <my-input type="number" placeholder="Отдел"
                      :model-value="employee.department.id"
                      @update:model-value="updateDepartmentId"/>
            <my-input type="number" placeholder="Человек"
                      :model-value="employee.person.id"
                      @update:model-value="updatePersonId"/>
            <button type="submit" @click="submit">Добавить</button>
        </div>
    </div>
</template>

<script>
import MyInput from "@/components/UI/MyInput.vue";
import {mapActions, mapGetters, mapMutations, mapState} from "vuex";

export default {
    name: "EmployeeContent",
    components: {MyInput},
    computed: {
        ...mapGetters(['employeeList', 'employeeCount']),
        ...mapState({
            employeeList: state => state.employee.employeeList,
            employee: state => state.employee.employee
        })
    },
    props: {
        show: {
            type: Boolean,
            default: false,
        },
    },
    methods: {
        ...mapActions(['fetchEmployee',
            'addEmployee',
            'editEmployee',
        ]),
        ...mapMutations(['setEmployeeList',
            'setEmployee',
            'setEmployeePerson',
            'setEmployeeSalary',
            'setEmployeePosition',
            'setEmployeeDepartment'
        ]),
        updatePersonId(value) {
            this.setEmployeePerson({person: {id: value}});
        },
        updateDepartmentId(value) {
            this.setEmployeeDepartment({department: {id: value}});
        },
        updatePositionId(value) {
            this.setEmployeePosition({position: {id: value}});
        },
        submit() {
            this.addEmployee({
                salary: this.employee.salary,
                personId: this.employee.person.person.id,
                departmentId: this.employee.department.department.id,
                positionId: this.employee.position.position.id,
            })
            console.log(JSON.parse(JSON.stringify(this.employee.department)).department.id)
            console.log(this.employee.person.person.id)
        },
        edit(employeeFromList) {
            this.editEmployee({
                id: employeeFromList.id,
                salary: employeeFromList.salary,
                personId: employeeFromList.person.id,
                departmentId: employeeFromList.department.id,
                positionId: employeeFromList.position.id,
            })
        }
    },
    async mounted() {
        await this.fetchEmployee();
    }
}
</script>

<style scoped>

</style>