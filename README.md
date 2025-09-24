# Coffeeshop App ☕

[![Kotlin](https://img.shields.io/badge/Kotlin-2.2.20-blue?logo=kotlin\&logoColor=white)](https://kotlinlang.org/) [![Android](https://img.shields.io/badge/Android-Compose-brightgreen?logo=android\&logoColor=white)](#) [![License: MIT](https://img.shields.io/badge/License-MIT-yellowgreen.svg)](#license)

> **Coffeeshop\_App** is an Android application built with **Jetpack Compose** that simulates (fake) online coffee ordering. It showcases a modern Compose UI with navigation, animations, and a simple cart/checkout flow.

---

## 📖 Table of Contents

* Overview
* Features
* Screenshots
* Tech Stack
* Installation
* Assets & Licenses
* Roadmap
* License
* Contact

---

## 🚀 Overview

Coffeeshop\_App is a demo e-commerce style app where users can browse a list of coffee items, search/filter them, add items to a cart, and place (fake) orders. Smooth animations, modern Material 3 UI, and Jetpack Compose best practices are highlighted throughout the project.

---

## ⭐ Features

* 🛒 **Shopping Cart** – add/remove items, view total price
* 📜 **Item List / Menu** – browse coffee items with details
* 🔍 **Search Bar** – filter items by name or category
* ✅ **Success Animation** – Lottie animation after placing (fake) order (`success.json`)
* 📱 **Bottom Navigation** – switch between main app sections
* ❌ **Not Found Page** – graceful handling of missing screens/routes
* 🎨 **Loading Animation** – Lottie animation while loading (`loading_dots.json`)
* ⚡ **Modern UI** – Jetpack Compose + Material 3 + smooth transitions

---


## 🛠 Tech Stack

**Language & UI**

* Kotlin
* Jetpack Compose (Material 3, ConstraintLayout)

**Architecture & Tools**

* MVVM (ViewModel + StateFlow)
* Hilt (DI)
* Navigation Compose
* KSP (for annotation processing)

**Data & Async**

* Kotlin Coroutines (Core + Android)
* Kotlinx Serialization (JSON)
* Datastore (Preferences + Core)

**Other**

* Lottie Compose (animations)

---

## ⚙️ Installation

Clone the repository:

```bash
git clone https://github.com/MHE47880/Coffeeshop_App.git
cd Coffeeshop_App
```

Open in **Android Studio**, let Gradle sync, then:

* Select an emulator/device
* Run the app (`Run > Run 'app'`)

That’s it — no extra setup required 🎉

---

## 🎨 Assets & Licenses

This project includes animations provided via [LottieFiles](https://lottiefiles.com/):

* `loading_dots.json` — Licensed under **Lottie Simple License**
* `success.json` — Licensed under **Lottie Simple License**

See the [Lottie Simple License](https://lottiefiles.com/page/license) for details.

---

## 📜 License

```
MIT License

Copyright (c) 2025 MohammadHossein Emami

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

---

## 📬 Contact

* Author: **MohammadHossein Emami**
* GitHub: [MHE47880](https://github.com/MHE47880)
