# TASK 2 DEMO FOR  Intelligent Healthcare Appointment Scheduling System

## 📌 Overview
This project implements a **Decentralized Multi-Agent System (MAS)** using **Java** and the **JADE framework** to optimize healthcare appointment scheduling.

It addresses common hospital challenges such as:
- Long patient waiting times
- Inefficient prioritization of urgent cases

The system replaces the traditional *first-come, first-served* model with a **dynamic, urgency-based scheduling approach**, where:
- Critical patients are prioritized automatically
- Routine cases are rescheduled through intelligent negotiation

---

##  Objectives
- Improve patient prioritization based on medical urgency  
- Reduce waiting times  
- Enable autonomous decision-making using agents  
- Implement negotiation strategies for scheduling conflicts  

---

##  System Architecture

### 🔹 Agents and Their Roles

#### 👤 Patient Agent
- Represents the patient
- Sends appointment requests using `REQUEST` messages
- Provides symptoms and availability

####  Triage Agent
- Analyzes patient symptoms
- Determines urgency level:
  - `CRITICAL`
  - `ROUTINE`
- Sends classification via `INFORM` messages
- Example: Detects keywords like *"chest pain"* for emergencies

####  Scheduler Agent (Negotiator)
- Manages doctor schedules
- Handles appointment conflicts
- Uses **Contract Net Protocol (`PROPOSE`)** for negotiation
- Offers incentives (e.g., discounts) to reschedule routine patients

---

