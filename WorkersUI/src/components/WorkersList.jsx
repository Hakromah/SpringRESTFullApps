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
		<div className="flex p-5 flex-col justify-center items-center">
			<h2 className="text-2xl text-teal-500 font-bold my-4">WORKERS LIST</h2>
			<Link to="/addWorker" className="text-blue-700 bg-zinc-200 p-2 rounded-md text-xl">Add New Worker</Link>
			<ul className="text-left">
				{workers.map((worker) => (
					<li key={worker.id} className="flex items-center">
						<Link className="text-blue-700" to={`/worker/${worker.id}`}>
							{worker.name} - {worker.specialization}
						</Link>
						<span className="text-red-700 text-xl ml-2 bg-red-100 font-bold px-2 pb-1">
							<button onClick={() => handleDelete(worker.id)}>
								Delete
							</button>
						</span>
						<Link
							to={`/editWorker/${worker.id}`}
							className="text-xl m-3 bg-green-400 px-2 text-yellow-300 font-bold"
						>
							Edit
						</Link>
					</li>
				))}
			</ul>
		</div>
	);
};

export default WorkersList;
