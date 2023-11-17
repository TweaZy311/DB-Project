<template>
  PASSPORT
    <div class="edit" v-if="show">
        <div class="input-group mb-3"
             v-for="passportFromList in passportList" v-bind:key="passportFromList.id">
            <div class="input-group-prepend">
            </div>
            <input type="number" v-model="passportFromList.id" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="number" v-model="passportFromList.serial" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="number" v-model="passportFromList.number" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <input type="date" v-model="passportFromList.validityPeriod" class="form-control" aria-label="Default"
                   aria-describedby="inputGroup-sizing-default">
            <button @click="edit(passportFromList)">Изменить</button>
        </div>
    </div>
    <div class="create" v-else>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
            </div>
            <my-input type="number" placeholder="Серия"
                      :model-value="passport.serial"
                      @update:model-value="setPassportSerial"/>
            <my-input type="number" placeholder="Номер"
                      :model-value="passport.number"
                      @update:model-value="setPassportNumber"/>
            <my-input type="date" placeholder="Срок действия"
                      :model-value="passport.validityPeriod"
                      @update:model-value="setPassportValidityPeriod"/>
            <button type="submit" @click="submit">Добавить</button>
        </div>
    </div>
</template>

<script>
import MyInput from "@/components/UI/MyInput.vue";
import {mapActions, mapGetters, mapMutations, mapState} from "vuex";

export default {
    name: "PassportContent",
    components: {MyInput},
    computed: {
        ...mapGetters(['passportList', 'passportCount']),
        ...mapState({
            passportList: state => state.passport.passportList,
            passport: state => state.passport.passport
        })
    },
    props: {
        show: {
            type: Boolean,
            default: false,
        },
    },
    methods: {
        ...mapActions(['fetchPassport',
            'addPassport',
            'editPassport',
        ]),
        ...mapMutations(['setPassportList',
            'setPassport',
            'setPassportNumber',
            'setPassportSerial',
            'setPassportValidityPeriod'
        ]),
        submit() {
            this.addPassport({
                number: this.passport.number,
                serial: this.passport.serial,
                validityPeriod: this.passport.validityPeriod
            })
        },
        edit(passportFromList) {
            this.editPassport({
                id: passportFromList.id,
                number: this.passport.number,
                serial: this.passport.serial,
                validityPeriod: this.passport.validityPeriod
            })
        }
    },
    async mounted() {
        await this.fetchPassport();
    }
}
</script>

<style scoped>

</style>