# 📱 FactDrop – Endless Useless Knowledge at Your Fingertips

FactDrop is a fun Android app that delivers random, silly facts to brighten your day. Whether you’re browsing through an endless feed of facts or checking the “fact of the day,” FactDrop keeps you entertained. You can also save your favorite facts to revisit them later!

---

## 🚀 Features

- 🔄 **Browse Random Facts:** Swipe through randomly generated facts.
- 📆 **Daily Fact:** See a new featured fact every day.
- ⭐ **Save Favorites:** Bookmark your favorite facts to view later.
- 🧭 **Clean Navigation:** Hamburger menu for simple navigation.
- 📲 **Modern Design:** Responsive UI using ConstraintLayout and LinearLayout.
- 📦 **Offline Access:** Favorites stored locally using Room database.

---

## 🛠️ How It Works

- **REST API:** Uses [Random Useless Facts API](https://uselessfacts.jsph.pl/)  
  - `GET /api/v2/facts/random` – Returns a random fact  
  - `GET /api/v2/facts/today` – Returns a fixed "daily" fact  

- **Room Database:** Saves favorites with ID and text fields.

- **Architecture:** Built with MVVM (Model-View-ViewModel)  
  - `Model`: API and database logic  
  - `ViewModel`: Manages app data and logic  
  - `View`: Fragments display data and handle UI

---

## 📸 Screenshots

<!-- Add screenshots when available -->
- Browse Facts Screen  
- Today’s Fact Screen  
- Favorites Screen  

---

## 📦 Requirements

- Android Studio (Electric Eel or newer)
- Android SDK 33+
- One physical or virtual Android device (API 30+ recommended)
- Internet connection for API requests

---

## ⚙️ Installation & Setup

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/factdrop.git
   cd factdrop
