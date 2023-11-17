<template>
  LUGGAGE
    <div class="edit" v-if="show">
        <div class="input-group mb-3"
             v-for="luggageFromList in luggageList" v-bind:key="luggageFromList.id">
            <div class="input-group-prepend">
            </div>
            <input type="number" v-model="luggageFromList.id" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="number" v-model="luggageFromList.size" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="number" v-model="luggageFromList.weight" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="number" v-model="luggageFromList.passenger.id" class="form-control"
                   aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <button @click="edit(luggageFromList)">Изменить</button>
        </div>
    </div>
    <div class="create" v-else>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
            </div>
            <my-input type="number" placeholder="Объем"
                      :model-value="luggage.size"
                      @update:model-value="setLuggageSize"/>
            <my-input type="number" placeholder="Вес"
                      :model-value="luggage.weight"
                      @update:model-value="setLuggageWeight"/>
            <my-input type="number" placeholder="Пассажир"
                      :model-value="luggage.passenger.id"
                      @update:model-value="updatePassengerId"/>
            <button type="submit" @click="submit">Добавить</button>
        </div>
    </div>
</template>

<script>
import MyInput from "@/components/UI/MyInput.vue";
import {mapActions, mapGetters, mapMutations, mapState} from "vuex";

export default {
    name: "LuggageContent",
    components: {MyInput},
    computed: {
        ...mapGetters(['luggageList', 'luggageCount']),
        ...mapState({
            luggageList: state => state.luggage.luggageList,
            luggage: state => state.luggage.luggage
        })
    },
    props: {
        show: {
            type: Boolean,
            default: false,
        },
    },
    methods: {
        ...mapActions(['fetchLuggage',
            'addLuggage',
            'editLuggage',
        ]),
        ...mapMutations(['setLuggageList',
            'setLuggage',
            'setLuggageSize',
            'setLuggageWeight',
            'setLuggagePassenger',
        ]),
        updatePassengerId(value) {
            this.setLuggagePassenger({passenger: {id: value}});
        },
        submit() {
            this.addLuggage({
                weight: this.luggage.weight,
                size: this.luggage.size,
                passengerId: this.luggage.passenger.passenger.id
            })
            console.log(this.luggage.passenger.passenger.id)
        },
        edit(luggageFromList) {
            this.editLuggage({
                id: luggageFromList.id,
                weight: luggageFromList.weight,
                size: luggageFromList.size,
                passengerId: luggageFromList.passenger.id
            })
        }
    },
    async mounted() {
        await this.fetchLuggage();
    }
}
</script>

<style scoped>

</style>