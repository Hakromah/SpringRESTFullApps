import { useEffect, useState } from "react";
import { fetchWorkerById } from "../services/WorkersServices";
import { useParams } from "react-router-dom";

const WorkerDetails = () => {
	const { id } = useParams();
	const [worker, setWorker] = useState(null);

	useEffect(() => {
		const workerDetail = async () => {
			try {
				const response = await fetchWorkerById(id);
				setWorker(response);
			} catch (error) {
				console.log("There is no worker with id: " + id + " " + error);
			}
		};
		workerDetail();
	}, [id]);

	return (
		<div>
			{worker ? (
				<div>
					<h2>{worker.name}</h2>
					<p>Email: {worker.email}</p>
					<p>Address: {worker.address}</p>
					<p>Phone: {worker.phoneNumber}</p>
					<p>Specialization: {worker.specialization}</p>
				</div>
			) : (
				<p>Loading...</p>
			)}
		</div>
	);
};

export default WorkerDetails;
