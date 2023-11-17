<template>
  FLIGHT
    <div class="edit" v-if="show">
        <div class="input-group mb-3"
             v-for="flightFromList in flightList" v-bind:key="flightFromList.id">
            <div class="input-group-prepend">
            </div>
            <input type="number" v-model="flightFromList.id" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="text" v-model="flightFromList.departurePoint" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="text" v-model="flightFromList.destination" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="datetime-local" v-model="flightFromList.departureTime" class="form-control"
                   aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="number" v-model="flightFromList.employee.id" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <button @click="edit(flightFromList)">Изменить</button>
        </div>
    </div>
    <div class="create" v-else>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
            </div>
            <my-input type="text" placeholder="Пункт вылета"
                      :model-value="flight.departurePoint"
                      @update:model-value="setFlightDeparturePoint"/>
            <my-input type="text" placeholder="Пункт назначения"
                      :model-value="flight.destination"
                      @update:model-value="setFlightDestination"/>
            <my-input type="datetime-local" placeholder="Время вылета"
                      :model-value="flight.departureTime"
                      @update:model-value="setFlightDepartureTime"/>
            <my-input type="number" placeholder="Сотрудник"
                      :model-value="flight.employee.id"
                      @update:model-value="updateEmployeeId"/>
            <button type="submit" @click="submit">Добавить</button>
        </div>
    </div>
</template>

<script>
import MyInput from "@/components/UI/MyInput.vue";
import {mapActions, mapGetters, mapMutations, mapState} from "vuex";

export default {
    name: "FlightContent",
    components: {MyInput},
    computed: {
        ...mapGetters(['flightList', 'flightCount']),
        ...mapState({
            flightList: state => state.flight.flightList,
            flight: state => state.flight.flight
        })
    },
    props: {
        show: {
            type: Boolean,
            default: false,
        },
    },
    methods: {
        ...mapActions(['fetchFlight',
            'addFlight',
            'editFlight',
        ]),
        ...mapMutations(['setFlightList',
            'setFlight',
            'setFlightDeparturePoint',
            'setFlightDestination',
            'setFlightDepartureTime',
            'setFlightEmployee'
        ]),
        updateEmployeeId(value) {
            this.setFlightEmployee({employee: {id: value}});
        },
        submit() {
            this.addFlight({
                departurePoint: this.flight.departurePoint,
                departureTime: this.flight.departureTime,
                destination: this.flight.destination,
                employeeId: this.flight.employee.employee.id,
            })
            // console.log(JSON.parse(JSON.stringify(this.employee.department)).department.id)
            console.log(this.flight.employee.employee.id)
        },
        edit(flightFromList) {
            this.editFlight({
                id: flightFromList.id,
                departurePoint: flightFromList.departurePoint,
                departureTime: flightFromList.departureTime,
                destination: flightFromList.destination,
                employeeId: flightFromList.employee.id,
            })
        }
    },
    async mounted() {
        await this.fetchFlight();
    }
}
</script>

<style scoped>

</style>