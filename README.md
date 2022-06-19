# Career Hunter

### 💡 App idea 💡
The idea of this application is to find a job. You can consider it as a mini-analogue of the well-known hh.ru

##

# Architecture
<img src="https://github.com/Mr-Ratatu/Work-Found-App/blob/AN-02_work_list_screen/images/architecture.png" alt="Your image title" width="750"/>

### ViewOutput
Basic interface. Needed to communicate View with Presenter.

### DataProvider
Basic interface.
Designed to pass observable state from Presenter to View. The DataProvider does not interact directly with the Presenter, the data is passed through an additional ViewState interface

### ViewState
The interface through which the presenter passes data to the DataProvider for display on the UI.
The ViewState implementation holds a reference to the DataProvider implementation.

The ViewState layer is needed to isolate the presenter from direct interaction with specific Observable types (Flow, LiveData) in the DataProvider.
This approach adds flexibility in the choice of tools: if it is decided to replace all fields in the DataProvider from LiveData to Flow, we will not need to change the presenter code, we just need to edit or create an additional ViewState implementation.

### RouterInput
Basic interface. Needed to communicate Presenter with Router.

### InteractorInput
Basic interface. Needed to communicate Presenter with Interactor.

### ServiceInput
Basic interface. Needed to communicate Interactor with Service.

### Service
The service in this case acts as a repository that determines where to get data from.

##

## 📱 Screens 📱

<img src="https://github.com/Mr-Ratatu/Work-Found-App/blob/AN-02_work_list_screen/images/splash.jpg" alt="splash" width="250"/> <img src="https://github.com/Mr-Ratatu/Work-Found-App/blob/AN-02_work_list_screen/images/WorkList.jpg" alt="splash" width="250"/>


##

##  🛠 Libraries and tools 🛠

* HH.ru Api
* Kotlin
* Coroutines
* StateFlow/SharedFlow
* Retrofit, OkHttp
* Gson
* Dagger 2
* Room, DataStore
* Paging 3
* Coil
