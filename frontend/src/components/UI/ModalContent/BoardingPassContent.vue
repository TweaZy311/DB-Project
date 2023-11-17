<template>
    <div class="edit" v-if="show">
        <div class="input-group mb-3"
             v-for="boardingPassFromList in boardingPassList" v-bind:key="boardingPassFromList.id">
            <div class="input-group-prepend">
            </div>
            <input type="text" v-model="boardingPassFromList.id.flight.id" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="text" v-model="boardingPassFromList.id.passenger.id" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="text" v-model="boardingPassFromList.seatNumber" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <button @click="edit(boardingPassFromList)">Изменить</button>
        </div>
    </div>
    <div class="create" v-else>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
            </div>
            <my-input type="number" placeholder="ID рейса"
                      :model-value="boardingPass.id.flight.id"
                      @update:model-value="updateFlightId"/>
            <my-input type="number" placeholder="ID пассажира"
                      :model-value="boardingPass.id.passenger.id"
                      @update:model-value="updatePassengerId"/>
            <my-input type="number" placeholder="Номере места"
                      :model-value="boardingPass.seatNumber"
                      @update:model-value="setBoardingPassSeatNumber"/>
            <button type="submit" @click="submit">Добавить</button>
        </div>
    </div>
</template>

<script>
import {mapGetters, mapActions, mapMutations, mapState} from "vuex";
import MyInput from "@/components/UI/MyInput.vue";

export default {
    name: "BoardingPassContent",
    components: {MyInput},
    computed: {
        ...mapGetters(['boardingPassList', 'boardingPassCount']),
        ...mapState({
            boardingPassList: state => state.boardingPass.boardingPassList,
            boardingPass: state => state.boardingPass.boardingPass
        })
    },
    props: {
        show: {
            type: Boolean,
            default: false,
        },
    },
    methods: {
        ...mapActions(['fetchBoardingPass',
            'addBoardingPass',
            'editBoardingPass',
        ]),
        ...mapMutations(['setBoardingPass',
            'setBoardingPassList',
            'setBoardingPassId',
            'setBoardingPassSeatNumber',
        ]),
        updateFlightId(value) {
            this.setBoardingPass({flight: {id: value}});
        },
        updatePassengerId(value) {
            this.setBoardingPass({passenger: {id: value}});
        },
        submit() {
            this.addBoardingPass({
                idFlight: this.boardingPass.flight.id,
                idPassenger: this.boardingPass.passenger.id,
                seatNumber: this.boardingPass.seatNumber,
            })
        },
        edit(boardingPassFromList) {
            this.editBoardingPass({
                idFlight: boardingPassFromList.id.flight.id,
                idPassenger: boardingPassFromList.id.passenger.id,
                seatNumber: boardingPassFromList.seatNumber,
            })
        }
    },
    async mounted() {
        await this.fetchBoardingPass();
    }
}
</script>

<style scoped>

</style>