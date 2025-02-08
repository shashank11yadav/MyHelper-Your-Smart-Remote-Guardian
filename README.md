# MyHelper - Your Smart Remote Guardian

## Overview
**MyHelper** is an Android application designed to provide remote access and control over a lost or misplaced smartphone. The app allows users to retrieve contacts, change sound profiles, ring their phone, and even access location details using SMS commands.

## Features
- **Remote Contact Retrieval**: Retrieve saved contacts via SMS command.
- **Phone Locator**: Get the GPS location of your lost phone.
- **Profile Control**: Change the phone's sound profile from silent to normal remotely.
- **Ring Activation**: Trigger a loud ring on the device, even if it is in silent mode.
- **Device Lock**: Secure the phone remotely by setting a lock password.
- **Offline and Online Mode**: Can operate without an internet connection using SMS-based commands.

## Technologies Used
- **Programming Language**: Java
- **IDE**: Android Studio
- **Database**: SQLite
- **Cloud Services**: Google Firebase (for authentication and messaging)
- **Android Components**: Activities, Services, Broadcast Receivers, Content Providers

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/shashank11yadav/MyHelper-Your-Smart-Remote-Guardian.git
   ```
2. Open the project in **Android Studio**.
3. Build and run the application on an Android device.
4. Grant the necessary permissions (SMS, Contacts, Location, Device Administration).
5. Set up a secure passcode and enable the required functionalities from the app settings.

## Usage
1. **Register your credentials** within the app.
2. **Enable necessary permissions** for SMS, contacts, and location access.
3. Send predefined **SMS commands** from another device to:
   - Retrieve contacts: `MyHelper <password> getContact <contact_name>`
   - Get location: `MyHelper <password> getLocation`
   - Change profile: `MyHelper <password> ChangeProfile`
   - Ring phone: `MyHelper <password> RingNow`
   - Lock phone: `MyHelper <password> setScreenLock`
4. The app will execute the command and send a response via SMS.

## Security Considerations
- The application requires authentication before executing remote commands.
- Users can **block certain numbers** from sending commands to prevent misuse.
- Future updates will include **OTP-based authentication** for improved security.

## Future Enhancements
- Implement **OTP-based authentication** instead of static passwords.
- **Auto-delete passcode messages** after execution for added security.
- **Online mode for file access** using cloud storage.
- **Improved file transfer speeds** over the internet.

