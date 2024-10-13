<h1 align="center">MediSeek </h1>

<p align="center">
  <img src="./MEDISEEK%20LOGO.png" alt="MediSeek Logo">
</p>

## Overview

**MediSeek** is a !CONCEPTUAL! advanced, independent health care company that operates a multifaceted Hospital Management System (HMS) designed to optimize the efficiency, coordination, and accuracy of medical facilities across South Africa. Established in January 2020 in response to the coronavirus pandemic, MediSeek provides comprehensive healthcare services to a multitude of facilities and residences in major towns and cities.

This project introduces **MediSeek HMS**, a CRUD-based system that allows for seamless management of patient details, staff records, appointment scheduling, and prescription billing. The system is designed to relieve pressure on healthcare professionals and administrators by streamlining day-to-day operations and enabling cross-facility communication and referral capabilities.

---

## Table of Contents
1. [Features](#features)
2. [Technologies](#technologies)
3. [Installation](#installation)
4. [Usage](#usage)
5. [Program Structure](#program-structure)
6. [Interface Summary](#interface-summary)
7. [Help and Support](#help-and-support)
8. [Database Schema](#database-schema)
9. [Hardware and Software Requirements](#hardware-and-software-requirements)
10. [Contributing](#contributing)
11. [License](#license)

---

## Features

- **Staff Management**: 
  - Search and filter doctors based on specialty.
  - Add, remove, and update staff information.
  - Handle multiple user roles: Administrator, Doctor, Receptionist, and Pharmacist.
  
- **Patient Management**:
  - Admit, discharge, and update patient details.
  - Manage patient diagnoses and prescriptions.
  - Automatically generate and issue bills for prescriptions.

- **Appointment Scheduling**:
  - Schedule, view, and manage appointments.
  - Keep track of upcoming appointments for doctors and facilities.

- **Facility Management**:
  - Add and remove healthcare facilities.
  - Group facilities based on clinic/ICU status and helipad availability.
  
- **Cross-Facility Referrals**: 
  - Refer patients to specialists at other MediSeek facilities.
  
- **Data Consistency**: 
  - Ensure patient history, treatments, and records are up-to-date and accessible.
  
- **User-Friendly Interface**: 
  - Easy-to-navigate GUI tailored to different job roles.

---

## Technologies

- **Programming Language**: Java
- **Database**: Microsoft Access (using SQL for data manipulation)
- **Integrated Development Environment (IDE)**: NetBeans IDE 8.0 or newer
- **Additional Tools**: Microsoft Word for documentation, Microsoft Access for data storage

---

## Installation

1. Ensure that **Java JDK 8** is installed.
2. Install **NetBeans IDE** (8.0 or newer) for running the project.
3. Install **Microsoft Access 2019** for managing the HMS database.
4. Clone the project from the repository:

   ```bash
   git clone https://github.com/your-repo/mediseek-hms.git
   cd mediseek-hms

5. Open the project in NetBeans and set up the database connection to Microsoft Access.

---

## Usage

1. **Log in** using your staff credentials.
2. Access the respective dashboard based on your role (Admin, Doctor, Receptionist, or Pharmacist).
3. Manage patients, appointments, and facility data directly from the intuitive interface.
4. For administrators, update the directory of specialists and manage staff.
5. For pharmacists, issue prescriptions and generate billing documents.
6. Doctors can view patient history, update diagnoses, and handle referral cases to other specialists.

---

## Program Structure

- **Main Program**: The application begins with an opening loading screen, leading to a role-specific dashboard (Administrator, Doctor, Receptionist, Pharmacist).
- **CRUD Operations**: Allow for creating, reading, updating, and deleting records related to staff, patients, and facilities.
- **Data Access**: Data is stored and retrieved from Microsoft Access, allowing for easy scalability and reliability.

---

## Interface Summary

- **Loading Screen**: Initial screen with role selection.
- **Log-in Page**: Enter Staff_ID and password to access the system.
- **Main Dashboard**: Different tabs and functionalities for each role (Doctor, Administrator, Receptionist, Pharmacist).
- **Appointment Scheduler**: Dedicated UI for managing appointments.
- **Prescription Manager**: Generate and issue prescriptions through the GUI for pharmacists.

### Design Specifications:
- **Colors**: Light Green, White, Blue, and Black.
- **Logo**: Watermarked MediSeek logo on every page.
- **Layout**: Symmetrical and consistent UI elements across all pages.

---

## Help and Support

Each screen has access to an **Instruction Manual** that includes:

- How to view and update records
- Adding staff and patients
- Booking appointments
- Issuing prescriptions

For more advanced help, including backend code structure, a built-in API documents all major functions and processes.

---

## Database Schema

### Tables:

- **tblStaff**: (sName, sSurname, Gender, Job Description, Specialty, etc.)
- **tblResidences**: (Residence, Capacity, Province, etc.)
- **tblDirectory**: Directory of off-site specialists.
- **tblPatience**: Patient details including history and prescriptions.
- **tblAppointments**: Scheduled appointments.
- **tblSpecialties**: Specialty departments and codes.
- **tblMedicine**: Available medicines, costs, and descriptions.

---

## Hardware and Software Requirements

### Hardware:

- **Processor**: 1 GHz or faster.
- **RAM**: 1 GB for 32-bit, 2 GB for 64-bit.
- **Hard drive**: 32 GB or larger.
- **Display**: 800x600 or higher.

### Software:

- **OS**: Windows 10 or newer.
- **Applications**: 
  - NetBeans IDE 8.0
  - Microsoft Access 2019
  - Microsoft Word 2019
  - Java JDK 8

---

## Contributing

If you would like to contribute to this project, please fork the repository and create a pull request with your proposed changes. All contributions are welcome!

---

