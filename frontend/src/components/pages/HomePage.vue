<template>
  <navigation-bar></navigation-bar>
  <admin-table></admin-table>
</template>

<script>
import NavigationBar from "@/components/UI/Navbar.vue";
import AdminTable from "@/components/UI/AdminTable.vue";

export default {
    name: "HomePage",
    components: {AdminTable, NavigationBar}
}
</script>

<style scoped>

</style>