import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const WorkerForm = () => {
	const navigate = useNavigate();
	const [worker, setWorker] = useState({
		name: "",
		email: "",
		address: "",
		phoneNumber: "",
		specialization: "",
	});

	const handleChange = (e) => {
		setWorker({ ...worker, [e.target.name]: e.target.value });
	};

	const handleSubmit = async (e) => {
		e.preventDefault();
		try {
			const data= await axios.post(
				`http://localhost:8686/WorkersApi/api/saveWorker`,
				worker
			);
			setWorker(data)
			navigate("/");
		} catch (error) {
			console.loge("Failed to add worker " + error);
		}
	};

	return (
		<div className="">
			<h2>Add Worker</h2>
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
				<button type="submit">Save</button>
			</form>
		</div>
	);
};

export default WorkerForm;
