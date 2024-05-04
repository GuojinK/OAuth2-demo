import apiClient from "./axios";
const API = "/"

export const test = async():Promise<any> => {
    const res = await apiClient.get("/")
    return res
}