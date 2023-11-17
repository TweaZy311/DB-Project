<template>
    <div class="edit" v-if="show">
        <div class="input-group mb-3"
             v-for="personFromList in personList" v-bind:key="personFromList.id">
            <div class="input-group-prepend">
            </div>
            <div> {{ personFromList.id }}</div>
            <input type="text" v-model="personFromList.name" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="text" v-model="personFromList.secondName" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="text" v-model="personFromList.lastName" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="date" v-model="personFromList.dateOfBirth" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <button @click="edit(personFromList)">Изменить</button>
        </div>
    </div>
    <div class="create" v-else>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
            </div>
            <my-input type="text" placeholder="имя"
                      :model-value="person.name"
                      @update:model-value="setPerson"/>
            <my-input type="text" placeholder="фамилия"
                      :model-value="person.second_name"
                      @update:model-value="setPerson"/>
            <my-input type="text" placeholder="отчество"
                      :model-value="person.last_name"
                      @update:model-value="setPerson"/>
            <my-input type="date" placeholder="дата рождения"
                      :model-value="person.date_of_birth"
                      @update:model-value="setPerson"/>
            <button type="submit" @click="submit">Добавить</button>
        </div>
    </div>
</template>

<script>
import {mapGetters, mapActions, mapMutations, mapState} from "vuex";
import MyInput from "@/components/UI/MyInput.vue";

export default {
    name: "PersonContent",
    components: {MyInput},
    computed: {
        ...mapGetters(['personList', 'personCount']),
        ...mapState({
            personList: state => state.person.personList,
            person: state => state.person.person
        })
    },
    props: {
        show: {
            type: Boolean,
            default: false,
        },
    },
    methods: {
        ...mapActions(['fetchPerson', 'addPerson', 'editPerson']),
        ...mapMutations(['setPerson',
            'setPersonName',
            'setPersonSecondName',
            'setPersonLastName',
            'setPersonBirth']),
        submit() {
            this.addPerson({
                dateOfBirth: this.person.date_of_birth,
                name: this.person.name,
                secondName: this.person.second_name,
                lastName: this.person.last_name
            })
        },
        edit(personFromList) {
            this.editPerson({
                id: personFromList.id,
                dateOfBirth: personFromList.dateOfBirth,
                name: personFromList.name,
                secondName: personFromList.secondName,
                lastName: personFromList.lastName,
            })
        }
    },
    async mounted() {
        await this.fetchPerson();
    }
}
</script>

<style scoped>

</style>