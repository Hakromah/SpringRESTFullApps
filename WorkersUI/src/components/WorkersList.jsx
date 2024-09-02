import { useState, useEffect } from "react";
import { deleteWorker, fetchAllWorkers } from "../services/WorkersServices";
import { Link } from "react-router-dom";

const WorkersList = () => {
	const [workers, setWorkers] = useState([]);

	useEffect(() => {
		const fetctchWorker = async () => {
			try {
				const data = await fetchAllWorkers();
				console.log(setWorkers(data));
			} catch (error) {
				console.log(error);
			}
		};
		fetctchWorker();
	}, []);

	const handleDelete = (id) => {
		deleteWorker(id).then(() => {
			setWorkers(workers.filter((worker) => worker.id !== id));
		});
	};

	return (
		<div className="flex p-5 bg-red-700">
			<h2 className="bg-red-300">Workers List</h2>
			<Link to="/addWorker">Add New Worker</Link>
			<ul>
				{workers.map((worker) => (
					<li key={worker.id}>
						<Link to={`/worker/${worker.id}`}>
							{worker.name} - {worker.specialization}
						</Link>
						<button onClick={() => handleDelete(worker.id)}>
							Delete
						</button>
						<Link to={`/editWorker/${worker.id}`}>Edit</Link>
					</li>
				))}
			</ul>
		</div>
	);
};

export default WorkersList;
