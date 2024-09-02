import { createBrowserRouter, RouterProvider } from "react-router-dom";
import WorkersList from "./components/WorkersList";
import WorkerDetails from "./components/WorkerDetails";
import WorkerForm from "./components/WorkerForm";
import UpdateWorkerForm from "./components/UpdateWorkerForm";

const router = createBrowserRouter([
	{
		//path: "/",

		children: [
			{ path: "/", element: <WorkersList /> },
			{ path: "/worker/:id", element: <WorkerDetails /> },
			{ path: "/addWorker", element: <WorkerForm /> },
			{ path: "editWorker/:id", element: <UpdateWorkerForm /> },
		],
	},
]);

function App() {
	return <RouterProvider router={router} />;
}

export default App;
