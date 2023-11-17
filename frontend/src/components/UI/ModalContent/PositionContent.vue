<template>
  POSITION
    <div class="edit" v-if="show">
        <div class="input-group mb-3"
             v-for="positionFromList in positionList" v-bind:key="positionFromList.id">
            <div class="input-group-prepend">
            </div>
            <input type="number" v-model="positionFromList.id" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="text" v-model="positionFromList.name" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <button @click="edit(positionFromList)">Изменить</button>
        </div>
    </div>
    <div class="create" v-else>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
            </div>
            <my-input type="text" placeholder="Название"
                      :model-value="position.name"
                      @update:model-value="setPositionName"/>
            <button type="submit" @click="submit">Добавить</button>
        </div>
    </div>
</template>

<script>
import MyInput from "@/components/UI/MyInput.vue";
import {mapActions, mapGetters, mapMutations, mapState} from "vuex";

export default {
    name: "PositionContent",
    components: {MyInput},
    computed: {
        ...mapGetters(['positionList', 'positionCount']),
        ...mapState({
            positionList: state => state.position.positionList,
            position: state => state.position.position
        })
    },
    props: {
        show: {
            type: Boolean,
            default: false,
        },
    },
    methods: {
        ...mapActions(['fetchPosition',
            'addPosition',
            'editPosition',
        ]),
        ...mapMutations(['setPositionList',
            'setPosition',
            'setPositionName',
        ]),
        submit() {
            this.addPosition({
                name: this.position.name,
            })
        },
        edit(positionFromList) {
            this.editPosition({
                id: positionFromList.id,
                name: positionFromList.name,
            })
        }
    },
    async mounted() {
        await this.fetchPosition();
    }
}
</script>

<style scoped>

</style>