import axios, {AxiosInstance, AxiosRequestConfig, AxiosResponse,AxiosError} from "axios";

function createInstance(baseURL:string):AxiosInstance {
    const instance = axios.create({
        baseURL: baseURL,
        headers:{
            "Content-Type":'application/json'
        }
    })
        // Response interceptor to handle data preprocessing or to refresh tokens
        instance.interceptors.response.use((response: AxiosResponse) => {
            // Perform actions on the response data
            console.log(response.data);
            
            return response.data;
        }, (error: AxiosError) => {
            // Handle errors
            if (error.response) {
                switch (error.response.status) {
                    case 401:
                        // handle unauthorized
                        break;
                    case 403:
                        // handle forbidden
                        break;
                    case 500:
                        // handle server error
                        break;
                    default:
                        // handle other errors
                        break;
                }
            }
            return Promise.reject(error);
        });
    
        return instance;
}


// Creating an axios instance for a specific API
const apiClient = createInstance('http://localhost:8080');

export default apiClient;