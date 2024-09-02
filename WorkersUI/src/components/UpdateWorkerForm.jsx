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
			<form onSubmit={handleSubmit}>
				<div>
					<label>Name</label>
					<input
						type="text"
						name="name"
						value={worker.name}
						onChange={handleChange}
						required
					/>
				</div>
				<div>
					<label>Email</label>
					<input
						type="email"
						name="email"
						value={worker.email}
						onChange={handleChange}
						required
					/>
				</div>
				<div>
					<label>Address</label>
					<input
						type="text"
						name="address"
						value={worker.address}
						onChange={handleChange}
						required
					/>
				</div>
				<div>
					<label>Phone Number</label>
					<input
						type="text"
						name="phoneNumber"
						value={worker.phoneNumber}
						onChange={handleChange}
						required
					/>
				</div>
				<div>
					<label>Specialization</label>
					<input
						type="text"
						name="specialization"
						value={worker.specialization}
						onChange={handleChange}
						required
					/>
				</div>
				<button type="submit">Update</button>
			</form>
		</div>
	);
};

export default UpdateWorkerForm;
