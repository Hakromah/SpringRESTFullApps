import { useNavigate, useParams } from "react-router-dom";
import { fetchWorkerById, updateWorker } from "../services/WorkersServices";
import { useEffect, useState } from "react";

const UpdateWorkerForm = () => {
	const { id } = useParams();
	const navigate = useNavigate();

	const [worker, setWorker] = useState({
		name: "",
		email: "",
		address: "",
		phoneNumber: "",
		specialization: "",
	});
	useEffect(() => {
		const editWorker = async () => {
			try {
				const data = await fetchWorkerById(id);
				console.log(setWorker(data));
			} catch (error) {
				console.log(error);
			}
		};
		editWorker();
	}, [id]);

	const handleChange = (e) => {
		setWorker({ ...worker, [e.target.name]: e.target.value });
	};

	const handleSubmit = async (e) => {
		e.preventDefault();

		updateWorker(id, worker).then(() => navigate("/"));
	};

	return (

		<div className="senter">
			<h2>Edit Worker</h2>
			<form className="max-w-sm mx-auto" onSubmit={handleSubmit}>
				<div className="mb-5">
					<label
						htmlFor="name"
						className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
					>
						Your name
					</label>
					<input
						type="text"
						name="name"
						value={worker.name}
						onChange={handleChange}
						required
						className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
						placeholder="your name"
					/>
				</div>
				<div className="mb-5">
					<label
					htmlFor="email"
						className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
					>
						Your email
					</label>
					<input
						type="email"
						id="email"
						name="email"
						value={worker.email}
						onChange={handleChange}
						className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
						required
					/>
				</div>

				<div className="mb-5">
					<label
					htmlFor="address"
						className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
					>
						Your address
					</label>
					<input
						type="text"
						id="address"
						name="address"
						value={worker.address}
						onChange={handleChange}
						className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
						required
					/>
				</div>

				<div className="mb-5">
					<label
					htmlFor="phoneNumber"
						className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
					>
						Your Phone Number
					</label>
					<input
						type="text"
						name="phoneNumber"
						value={worker.phoneNumber}
						onChange={handleChange}
						required
						className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"

					/>
				</div>

				<div className="mb-5">
					<label
					htmlFor="phoneNumber"
						className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
					>
						Your Specialization
					</label>
					<input
						type="text"
						name="specialization"
						value={worker.specialization}
						onChange={handleChange}
						required
						className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"

					/>
				</div>
				<button
					type="submit"
					className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
				>
					Update
				</button>
			</form>
		</div>
	);
};

export default UpdateWorkerForm;
