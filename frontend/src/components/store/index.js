import Vuex from 'vuex'
import person from "@/components/store/modules/person";
import boardingPass from "@/components/store/modules/boardingPass";
import department from "@/components/store/modules/department";
import employee from "@/components/store/modules/employee";
import flight from "@/components/store/modules/flight";
import luggage from "@/components/store/modules/luggage";
import overweightLuggage from "@/components/store/modules/overweightLuggage";
import passenger from "@/components/store/modules/passenger";
import passport from "@/components/store/modules/passport";
import position from "@/components/store/modules/position";

export default new Vuex.Store({
    modules: {
        boardingPass: boardingPass,
        department: department,
        employee: employee,
        flight: flight,
        luggage: luggage,
        overweightLuggage: overweightLuggage,
        passenger: passenger,
        passport: passport,
        person: person,
        position: position,
    }
})