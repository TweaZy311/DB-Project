<template>
    <div class="table">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Таблица</th>
                <th scope="col">Описание</th>
                <th scope="col">Добавить</th>
                <th scope="col">Редактировать</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">Человек</th>
                <td>Содержит данные о людях</td>
                <td>
                    <button @click="showCreateModal(PersonContent)">**Кнопка**</button>
                </td>
                <td>
                    <button @click="showOverviewModal(PersonContent)">**Кнопка**</button>
                </td>
            </tr>
            <tr>
                <th scope="row">Паспорт</th>
                <td>Содержит паспортные данные</td>
                <td>
                    <button @click="showCreateModal(PassportContent)">**Кнопка**</button>
                </td>
                <td>
                    <button @click="showOverviewModal(PassportContent)">**Кнопка**</button>
                </td>
            </tr>
            <tr>
                <th scope="row">Пассажир</th>
                <td>Содержит данные о пассажирах</td>
                <td>
                    <button @click="showCreateModal(PassengerContent)">**Кнопка**</button>
                </td>
                <td>
                    <button @click="showOverviewModal(PassengerContent)">**Кнопка**</button>
                </td>
            </tr>
            <tr>
                <th scope="row">Сотрудник</th>
                <td>Содержит данные о сотрудниках</td>
                <td>
                    <button @click="showCreateModal(EmployeeContent)">**Кнопка**</button>
                </td>
                <td>
                    <button @click="showOverviewModal(EmployeeContent)">**Кнопка**</button>
                </td>
            </tr>
            <tr>
                <th scope="row">Должность</th>
                <td>Содержит данные о должностях</td>
                <td>
                    <button @click="showCreateModal(PositionContent)">**Кнопка**</button>
                </td>
                <td>
                    <button @click="showOverviewModal(PositionContent)">**Кнопка**</button>
                </td>
            </tr>
            <tr>
                <th scope="row">Отдел</th>
                <td>Содержит данные об отделах</td>
                <td>
                    <button @click="showCreateModal(DepartmentContent)">**Кнопка**</button>
                </td>
                <td>
                    <button @click="showOverviewModal(DepartmentContent)">**Кнопка**</button>
                </td>
            </tr>
            <tr>
                <th scope="row">Рейс</th>
                <td>Содержит данные о рейсах</td>
                <td>
                    <button @click="showCreateModal(FlightContent)">**Кнопка**</button>
                </td>
                <td>
                    <button @click="showOverviewModal(FlightContent)">**Кнопка**</button>
                </td>
            </tr>
            <tr>
                <th scope="row">Посадочный талон</th>
                <td>Содержит данные о посадочных талонах</td>
                <td>
                    <button @click="showCreateModal(BoardingPassContent)">**Кнопка**</button>
                </td>
                <td>
                    <button @click="showOverviewModal(BoardingPassContent)">**Кнопка**</button>
                </td>
            </tr>
            <tr>
                <th scope="row">Багаж</th>
                <td>Содержит данные о багажах</td>
                <td>
                    <button @click="showCreateModal(LuggageContent)">**Кнопка**</button>
                </td>
                <td>
                    <button @click="showOverviewModal(LuggageContent)">**Кнопка**</button>
                </td>
            </tr>
            <tr>
                <th scope="row">Багаж с перевесом</th>
                <td>Содержит данные о багажах с перевесом</td>
                <td>
                    <button @click="showCreateModal(OverweightLuggageContent)">**Кнопка**</button>
                </td>
                <td>
                    <button @click="showOverviewModal(OverweightLuggageContent)">**Кнопка**</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <modal-window v-model:show="overviewModalVisible">
        <component :is="currentComponent"
                   v-bind:personList="personList"
                   v-bind:person="person"
                   v-bind:show="typeContent"
        ></component>
    </modal-window>
    <modal-window v-model:show="createModalVisible">
        <component :is="currentComponent"
                   v-bind:show="typeContent"></component>
    </modal-window>
</template>

<script>
import PersonContent from "@/components/UI/ModalContent/PersonContent.vue";
import PassportContent from "@/components/UI/ModalContent/PassportContent.vue";
import PassengerContent from "@/components/UI/ModalContent/PassengerContent.vue";
import EmployeeContent from "@/components/UI/ModalContent/EmployeeContent.vue";
import PositionContent from "@/components/UI/ModalContent/PositionContent.vue";
import DepartmentContent from "@/components/UI/ModalContent/DepartmentContent.vue";
import FlightContent from "@/components/UI/ModalContent/FlightContent.vue";
import BoardingPassContent from "@/components/UI/ModalContent/BoardingPassContent.vue";
import LuggageContent from "@/components/UI/ModalContent/LuggageContent.vue";
import OverweightLuggageContent from "@/components/UI/ModalContent/OverweightLuggageContent.vue";
import ModalWindow from "@/components/UI/ModalWindow.vue";

export default {
    name: "AdminTable",
    computed: {
        OverweightLuggageContent() {
            return OverweightLuggageContent
        },
        LuggageContent() {
            return LuggageContent
        },
        BoardingPassContent() {
            return BoardingPassContent
        },
        FlightContent() {
            return FlightContent
        },
        DepartmentContent() {
            return DepartmentContent
        },
        PositionContent() {
            return PositionContent
        },
        EmployeeContent() {
            return EmployeeContent
        },
        PassengerContent() {
            return PassengerContent
        },
        PassportContent() {
            return PassportContent
        },
        PersonContent() {
            return PersonContent
        },
    },
    components: {ModalWindow},
    data() {
        return {
            overviewModalVisible: false,
            createModalVisible: false,
            typeContent: false,
            currentComponent: null,
            passportList: [],
        }
    },
    methods: {
        showOverviewModal(component) {
            this.currentComponent = component
            this.typeContent = true;
            this.overviewModalVisible = true;
        },
        showCreateModal(component) {
            this.currentComponent = component
            this.typeContent = false;
            this.createModalVisible = true;
        },
    },
}
</script>

<style>
button{
    transition: 0.5s;
}
button:hover{
    transform: perspective(500px) rotateY(45deg);
}
</style>