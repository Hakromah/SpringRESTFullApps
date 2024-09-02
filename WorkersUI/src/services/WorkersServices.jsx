import axios from "axios";

const wkApi = "http://localhost:8686/WorkersApi/api/fetchAllWorkers";

export const fetchAllWorkers = async () => {
	try {
		const response = await axios.get(wkApi);
		return response.data;
	} catch (error) {
		console.loge(error);
		return [];
	}
};

export const fetchWorkerById = async (id) => {
	try {
		const response = await axios.get(
			`http://localhost:8686/WorkersApi/api/fetchWorkers/${id}`
		);
		return response.data;
	} catch (error) {
		console.loge("Data could not be fetched " + error);
	}
};

/*export const saveWorker = async (worker) => {
	try {
		const response = await axios.post(
			`http://localhost:8686/WorkersApi/api/saveWorker/`,
			worker
		);
		return response.data;
	} catch (error) {
		console.loge(error);
	}
};*/
export const saveWorker = async (worker) => {
	return await axios.post(
		`http://localhost:8686/WorkersApi/api/saveWorker`,
		worker
	);
};

export const updateWorker = async (id, worker) => {
	return await axios.put(
		`http://localhost:8686/WorkersApi/api/worker/${id}`,
		worker
	);
};

export const deleteWorker = async (id) => {
	try {
		const response = await axios.delete(
			`http://localhost:8686/WorkersApi/api/deleteWorker/${id}`
		);
		return response.data;
	} catch (error) {
		console.loge("Failed to delete worker " + error);
	}
};
