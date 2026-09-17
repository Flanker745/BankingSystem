# 🏧 ATM Simulation System

## 📌 Problem Statement

Traditional ATM systems provide users with basic banking services such as checking balance, depositing money, withdrawing money, and managing account information.

The objective of this project is to develop a simple **terminal-based ATM Simulation System using Java** that demonstrates these basic ATM operations in a controlled software environment.

The system allows users to authenticate themselves using an account number and PIN and then perform different banking operations. It also provides account management features and stores account and transaction information using text files.

The project is designed to provide a simple implementation of an ATM system while applying Java programming, object-oriented programming, collections, file handling, and input validation concepts.

---

## 🎯 Scope of the Project

The scope of this project is limited to a **basic ATM simulation** that runs through the terminal.

The system includes:

- User login using account number and PIN.
- Checking the current account balance.
- Depositing money into an account.
- Withdrawing money from an account.
- Viewing transaction history.
- Changing the account PIN.
- Deleting an account.
- Creating new accounts.
- Removing existing accounts.
- Storing account information in a text file.
- Storing transaction information in a separate text file.
- Validating deposit and withdrawal amounts.
- Applying basic account balance limits.

The project does not connect to a real bank, real ATM hardware, or an external banking database. It is intended only for educational and simulation purposes.

---

## 👥 Target Users

The project is mainly intended for:

- **Students** learning Java programming.
- **Beginners** learning object-oriented programming.
- Users who want to understand the basic workflow of an ATM system.
- Students practicing Java file handling and collections.
- Students who want to understand how multiple Java classes can be combined to create a simple application.

---

## ✨ High-Level Features

### 🔐 Account Authentication

- Account number and PIN based login.
- Account verification.
- PIN verification.
- Invalid login handling.

### 💰 Banking Operations

- Check balance.
- Deposit money.
- Withdraw money.
- View transaction history.
- Change PIN.

### 👤 Account Management

- Add a new account.
- Automatically generate an account number.
- Remove an account.
- Delete the currently logged-in account.

### 💾 File-Based Storage

- Store account details in `accounts.txt`.
- Store transaction details in `transactions.txt`.
- Read account information when the application starts.
- Save updated account information after changes.

### ✅ Validation

- Minimum initial deposit of ₹1,000.
- Maximum initial deposit of ₹1,00,000.
- Maximum account balance of ₹1,00,000.
- Prevent zero or negative deposits.
- Prevent zero or negative withdrawals.
- Prevent withdrawals greater than the available balance.
- Confirm PIN while creating or changing a PIN.