import axios from "axios";

const Rest_Api='http://localhost:8080/api/employees';

export const listEmployee = () => {
    return axios.get(Rest_Api);
}