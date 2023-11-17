<template>
  OVERWEIGHT LUGGAGE
    <div class="edit" v-if="show">
        <div class="input-group mb-3"
             v-for="luggageFromList in overweightLuggageList" v-bind:key="luggageFromList.id">
            <div class="input-group-prepend">
            </div>
            <input type="number" v-model="luggageFromList.id" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="number" v-model="luggageFromList.overweight" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="number" v-model="luggageFromList.overweightSerchage" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="number" v-model="luggageFromList.luggage.id" class="form-control"
                   aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <button @click="edit(luggageFromList)">Изменить</button>
        </div>
    </div>
    <div class="create" v-else>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
            </div>
            <my-input type="number" placeholder="Перевес"
                      :model-value="overweightLuggage.overweight"
                      @update:model-value="setOverweightLuggageOverweight"/>
            <my-input type="number" placeholder="Плата за перевес"
                      :model-value="overweightLuggage.overweightSerchage"
                      @update:model-value="setOverweightLuggageSerchage"/>
            <my-input type="number" placeholder="Багаж"
                      :model-value="overweightLuggage.luggage.id"
                      @update:model-value="updateLuggageId"/>
            <button type="submit" @click="submit">Добавить</button>
        </div>
    </div>
</template>

<script>
import MyInput from "@/components/UI/MyInput.vue";
import {mapActions, mapGetters, mapMutations, mapState} from "vuex";

export default {
    name: "OverweightLuggageContent",
    components: {MyInput},
    computed: {
        ...mapGetters(['overweightLuggageList', 'overweightLuggageCount']),
        ...mapState({
            overweightLuggageList: state => state.overweightLuggage.overweightLuggageList,
            overweightLuggage: state => state.overweightLuggage.overweightLuggage
        })
    },
    props: {
        show: {
            type: Boolean,
            default: false,
        },
    },
    methods: {
        ...mapActions(['fetchOverweightLuggage',
            'addOverweightLuggage',
            'editOverweightLuggage',
        ]),
        ...mapMutations(['setOverweightLuggageList',
            'setOverweightLuggage',
            'setOverweightLuggageOverweight',
            'setOverweightLuggageSerchage',
            'setOverweightLuggageLuggage',
        ]),
        updateLuggageId(value) {
            this.setOverweightLuggageLuggage({luggage: {id: value}});
        },
        submit() {
            this.addOverweightLuggage({
                overweight: this.overweightLuggage.overweight,
                overweightSerchage: this.overweightLuggage.overweightSerchage,
                luggageId: this.overweightLuggage.luggage.luggage.id
            })
            console.log(this.overweightLuggage.luggage.luggage.id)
        },
        edit(luggageFromList) {
            this.editOverweightLuggage({
                id: luggageFromList.id,
                overweight: luggageFromList.overweight,
                overweightSerchage: luggageFromList.overweightSerchage,
                luggageId: luggageFromList.luggage.id
            })
        }
    },
    async mounted() {
        await this.fetchOverweightLuggage();
    }
}
</script>

<style scoped>

</style>