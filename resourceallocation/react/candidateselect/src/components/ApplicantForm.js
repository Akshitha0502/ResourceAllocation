import React, { useState } from "react";
import axiosInstance from "../api/axiosConfig";

const ApplicantForm = ({ onApplicantAdded }) => {
  const [id, setId] = useState("");
  const [name, setName] = useState("");
  const [experience, setExperience] = useState("");
  const [skills, setSkills] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axiosInstance.post("/applicants", { id, name, experience, skills });
      setId("");
      setName("");
      setExperience("");
      setSkills("");
      onApplicantAdded();
    } catch (error) {
      console.error("Error adding Applicant:", error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Resource Allocation</h2>
      <label htmlFor="">Enter Id:</label>
      <input
        type="text"
        value={id}
        placeholder="Enter Id"
        onChange={(e) => setId(e.target.value)}
      />
      <br />
      <label htmlFor="">Enter Name :</label>
      <input
        type="text"
        value={name}
        onChange={(e) => setName(e.target.value)}
        placeholder="Enter name"
      />
      <br />
      <label htmlFor="">Enter Experience</label>
      <input
        type="text"
        value={experience}
        placeholder="Enter experience"
        onChange={(e) => setExperience(e.target.value)}
      />{" "}
      <br />
      <label htmlFor="">Enter Skills:</label>
      <input
        type="text"
        value={skills}
        placeholder="Enter skills"
        onChange={(e) => setSkills(e.target.value)}
      />
      <br />
      <button type="submit">Add Applicant</button>
    </form>
  );
};

export default ApplicantForm;
