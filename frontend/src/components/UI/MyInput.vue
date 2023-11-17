<template>
    <input :value="modelValue"
           @input="updateInput" class="form-control" aria-label="Default"
           aria-describedby="inputGroup-sizing-default" type="text">
</template>

<script>
export default {
    name: "my-input",
    props:{
        modelValue: [String, Date, Number, Object]
    },
    methods: {
        updateInput(event) {
            this.$emit('update:modelValue', event.target.value)
        }
    }
}
</script>

<style scoped>

</style>