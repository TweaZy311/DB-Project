<template>
  DEPARTMENT
    <div class="edit" v-if="show">
        <div class="input-group mb-3"
             v-for="departmentFromList in departmentList" v-bind:key="departmentFromList.id">
            <div class="input-group-prepend">
            </div>
            <input type="number" v-model="departmentFromList.id" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="text" v-model="departmentFromList.name" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="text" v-model="departmentFromList.address" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <button @click="edit(departmentFromList)">Изменить</button>
        </div>
    </div>
    <div class="create" v-else>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
            </div>
            <my-input type="text" placeholder="Название"
                      :model-value="department.name"
                      @update:model-value="setDepartmentName"/>
            <my-input type="text" placeholder="Адрес"
                      :model-value="department.address"
                      @update:model-value="setDepartmentAddress"/>
            <button type="submit" @click="submit">Добавить</button>
        </div>
    </div>
</template>

<script>
import MyInput from "@/components/UI/MyInput.vue";
import {mapActions, mapGetters, mapMutations, mapState} from "vuex";

export default {
    name: "DepartmentContent",
    components: {MyInput},
    computed: {
        ...mapGetters(['departmentList', 'departmentCount']),
        ...mapState({
            departmentList: state => state.department.departmentList,
            department: state => state.department.department
        })
    },
    props: {
        show: {
            type: Boolean,
            default: false,
        },
    },
    methods: {
        ...mapActions(['fetchDepartment',
            'addDepartment',
            'editDepartment',
        ]),
        ...mapMutations(['setDepartmentList',
            'setDepartment',
            'setDepartmentAddress',
            'setDepartmentName',
        ]),
        submit() {
            this.addDepartment({
                name: this.department.name,
                address: this.department.address,
            })
        },
        edit(departmentFromList) {
            this.editDepartment({
                id: departmentFromList.id,
                name: departmentFromList.name,
                address: departmentFromList.address,
            })
        }
    },
    async mounted() {
        await this.fetchDepartment();
    }
}
</script>

<style scoped>

</style>