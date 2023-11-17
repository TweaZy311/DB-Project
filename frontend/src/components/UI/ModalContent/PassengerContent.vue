<template>
  PASSENGER
    <div class="edit" v-if="show">
        <div class="input-group mb-3"
             v-for="passengerFromList in passengerList" v-bind:key="passengerFromList.id">
            <div class="input-group-prepend">
            </div>
            <input type="number" v-model="passengerFromList.id" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="datetime-local" v-model="passengerFromList.registrationDate" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="number" v-model="passengerFromList.person.id" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="number" v-model="passengerFromList.passport.id" class="form-control"
                   aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <button @click="edit(passengerFromList)">Изменить</button>
        </div>
    </div>
    <div class="create" v-else>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
            </div>
            <my-input type="datetime-local" placeholder="Дата регистрации"
                      :model-value="passenger.registrationDate"
                      @update:model-value="setPassengerRegistrationDate"/>
            <my-input type="number" placeholder="Паспорт"
                      :model-value="passenger.passport.id"
                      @update:model-value="updatePassportId"/>
            <my-input type="number" placeholder="Человек"
                      :model-value="passenger.person.id"
                      @update:model-value="updatePersonId"/>
            <button type="submit" @click="submit">Добавить</button>
        </div>
    </div>
</template>

<script>
import MyInput from "@/components/UI/MyInput.vue";
import {mapActions, mapGetters, mapMutations, mapState} from "vuex";

export default {
    name: "PassengerContent",
    components: {MyInput},
    computed: {
        ...mapGetters(['passengerList', 'passengerCount']),
        ...mapState({
            passengerList: state => state.passenger.passengerList,
            passenger: state => state.passenger.passenger
        })
    },
    props: {
        show: {
            type: Boolean,
            default: false,
        },
    },
    methods: {
        ...mapActions(['fetchPassenger',
            'addPassenger',
            'editPassenger',
        ]),
        ...mapMutations(['setPassengerList',
            'setPassenger',
            'setPassengerRegistrationDate',
            'setPassengerPassport',
            'setPassengerPerson',
        ]),
        updatePassportId(value) {
            this.setPassengerPassport({passport: {id: value}});
        },
        updatePersonId(value) {
            this.setPassengerPerson({person: {id: value}});
        },
        submit() {
            this.addPassenger({
                registrationDate: this.passenger.registrationDate,
                passportId: this.passenger.passport.passport.id,
                personId: this.passenger.person.person.id
            })
            // console.log(JSON.parse(JSON.stringify(this.employee.department)).department.id)
            console.log(this.passenger.person.person.id)
        },
        edit(passengerFromList) {
            this.editPassenger({
                id: passengerFromList.id,
                registrationDate: passengerFromList.registrationDate,
                passportId: passengerFromList.passport.id,
                personId: passengerFromList.person.id
            })
        }
    },
    async mounted() {
        await this.fetchPassenger();
    }
}
</script>

<style scoped>

</style>