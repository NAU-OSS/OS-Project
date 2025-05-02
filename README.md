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

## 📸 Screenshots CHANGE THIS

- Browse Facts Screen
  
  ![browse_fact](https://github.com/user-attachments/assets/a2b645df-334c-45c3-9a89-24c3f3b5f8c0)

- Today’s Fact Screen
  
  ![daily_fact](https://github.com/user-attachments/assets/2d82d924-16ea-4847-9a23-3c1dfccb2826)

- Favorites Screen
   
  ![favorites_fact](https://github.com/user-attachments/assets/486bc8c8-f1cf-45b4-af03-1ae53ea9a52c)
---

## 📦 Requirements CHECK THIS 

- Android Studio (Electric Eel or newer)
- Android SDK 33+
- One physical or virtual Android device (API 30+ recommended)
- Internet connection for API requests

---

## ⚙️ Installation & Setup

1. **Clone the Repository**
   ```bash
   git clone https://github.com/kkarissa/CS377-FinalProject.git
   cd CS377-FinalProject
2. **Open the Project in Android Studio**
    - Launch Android Studio
    - Click `File > Open`
    - Select the `CS377-FinalProject` folder
3. **Build and Run**
    - Let Gradle sync and finish building
    - Connect a device or use an emulator
    - Click Run ▶️ to install and launch the app
4. **Using the App**
    - Use the hamburger menu to navigate
    - Browse facts, check today's fact, and save to favorites
  
---

## 📁 Project Structure

```
CS377-FinalProject/
├── app/src/main
│   ├── java/com/example/finalproject/ # Kotlin source code
│   │   ├── data/                      # Data-related packages
|   |   |   ├── database/              # Room database classes
|   |   |   ├── model/                 # Main Fact data class
|   |   |   ├── network/               # Retrofit classes
|   |   |   └── repository/            # FactRepository class
│   │   └── ui/                        # Main fragment classes
|   |       ├── adapter/               # Adapter class for favorites RecyclerView
|   |       └── viewmodel/             # FactViewModel class
│   └── res/                           # Layouts, navigation, strings, etc.
└── build.gradle                       # Project configuration
```

---

## 🧩 Key Libraries Used

- [Retrofit](https://square.github.io/retrofit/) – API client  
- [Room](https://developer.android.com/jetpack/androidx/releases/room) – Local database  

---

## 🧪 Troubleshooting

| Issue                  | Solution                                          |
|------------------------|---------------------------------------------------|
| Project fails to build | Run `File > Invalidate Caches / Restart`         |
| API response is null   | Check your internet connection                   |
| Favorites not saved    | Ensure Room DB permissions and setup are correct |
| App crashes on launch  | Confirm all Gradle dependencies are synced       |

---

## 👥 Authors

- **Karissa Smallwood** – UI/UX Design, App Navigation  
- **Peter Hilbert** – API Integration, Database Management  

---

## 🤝 Contributing

This project was built for academic purposes and is not actively maintained for contributions.  
However, feel free to fork the repository or open an issue with feedback or questions.

---

## 📫 Contact

Reach us on GitHub:

- [@kkarissa](https://github.com/kkarissa)  
- [@pehilbert](https://github.com/pehilbert)
