// src/components/BookList.js
import React, { useEffect, useState } from "react";
import axiosInstance from "../api/axiosConfig";
import ApplicantForm from "./ApplicantForm";

const ApplicantList = () => {
  const [Applicants, setApplicants] = useState([]);

  useEffect(() => {
    fetchApplicants();
  }, []);

  const fetchApplicants = async () => {
    try {
      const response = await axiosInstance.get("/applicants");
      setApplicants(response.data);
    } catch (error) {
      console.error("Error occurred while retrieving the applicants:", error);
    }
  };

  const deleteApplicant = async (id) => {
    try {
      await axiosInstance.delete(`/applicants/${id}`);
      fetchApplicants();
    } catch (error) {
      console.error("Error occurred while deleting the record:", error);
    }
  };

  return (
    <div>
      <h1>Resource Selection</h1>
      <ApplicantForm onApplicantAdded={fetchApplicants} />
      <h2>Resource List</h2>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Experience</th>
            <th>Skills</th>
            <th>Remove</th>
          </tr>
        </thead>
        <tbody>
          {Applicants.map((Applicant) => (
            <tr>
              <td>{Applicant.id}</td>
              <td>{Applicant.name}</td>
              <td>{Applicant.experience}</td>
              <td>{Applicant.skills}</td>
              <td>
                <button onClick={() => deleteApplicant(Applicant.id)}>
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ApplicantList;
