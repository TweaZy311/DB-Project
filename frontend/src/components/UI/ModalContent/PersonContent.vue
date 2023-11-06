<template>
    <div class="edit" v-if="show">
        <div>{{personCount}}</div>
        <div class="input-group mb-3"
             v-for="personFromList in personList" v-bind:key="personFromList.id">
            <div class="input-group-prepend">
            </div>
            <input type="text" v-model="personFromList.name" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="text" v-model="personFromList.secondName" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="text" v-model="personFromList.lastName" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="text" v-model="personFromList.dateOfBirth" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <button @click="getList">Изменить</button>
        </div>
    </div>
    <div class="create" v-else>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
            </div>
            <input type="text" placeholder="имя"
                   v-model="person.name" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="text" placeholder="фамилия"
                   v-model="person.second_name" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="text" placeholder="отчество"
                   v-model="person.last_name" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="date" placeholder="дата рождения"
                   v-model="person.date_of_birth" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <button type="submit" @click="submit">Добавить</button>
        </div>
    </div>
</template>

<script>
import {mapGetters, mapActions, mapMutations} from "vuex";

export default {
    name: "PersonContent",
    computed: {
        ...mapGetters(['personList', 'personCount']),
    },
    props: {
        show: {
            type: Boolean,
            default: false,
        },
    },
    data(){
        return{
            person: {
                date_of_birth: '',
                name: '',
                second_name: '',
                last_name: '',
            },
        }
    },
    methods: {
        ...mapActions(['fetchPerson', 'addPerson']),
        ...mapMutations(['setPerson']),
        submit(){
            this.addPerson({dateOfBirth: this.person.date_of_birth,
            name: this.person.name,
            secondName: this.person.second_name,
            lastName: this.person.last_name})
        },


    },
    async mounted() {
        await this.fetchPerson();
    }
}
</script>

<style scoped>

</style>