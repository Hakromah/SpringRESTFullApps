import { useEffect, useState } from "react";
import { fetchWorkerById } from "../services/WorkersServices";
import { Link, useParams } from "react-router-dom";

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
		<div className="flex p-5 flex-col justify-center items-center mt-5">
		<h1 className="text-2xl font-bold"> <Link to={"/"} className="mr-2 text-xl bg-lime-600 px-2 rounded-md">
		Back</Link>Full Details</h1>
			{worker ? (
				<div className="flex flex-col gap-2 text-xl">
					<h2 className="text-2xl text-blue-950">{worker.name}</h2>
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
