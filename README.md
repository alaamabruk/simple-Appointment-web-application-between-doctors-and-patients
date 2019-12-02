# simple-Appointment-web-application-between-doctors-and-patients
Patient should be available to view all the available time slots of a doctor so he would be able to make an appointment.

# appointment-web-app
simple Appointment web application between doctors and patients.

# notes the application 
 * the application has 3 services and configuration service(Eureka Server) 
 that hold all the configuration for those services.
 * using local DataBase (MYSQL).
 
# application services :
     * gateway micro service : runs on port 8005
     * doctor micro service : runs on port 8000  
     * patient micro service : runs on port 8001
     * Eureka server : runs on port 8761

# steps 
    1.create a database called `doctor-system`
    2.prepare your enviroment if you work locally or on a production :
      * clone the git repository
      * setup java ide (sts, intelij,etc)
      * import the 4 services in the ide and download dependencies.
    3. run Eureka server
    4. run the 3 services.
    5. you can now work with the rest apis.

# endpoints ( default is GET )
    * localhost:8005/api/users/register-doctor           //register a doctor (POST)
    * localhost:8005/api/users/register-patient          // register a patient (POST)       
    * localhost:8005/api/users/is-authenticate
    * localhost:8000/api/appointments                    // return all appointments
    * localhost:8000/api/add-Appointment                  // Doctor add appointments (POST)
    * localhost:8000/api/appointments/available          // return all available appointments
    * localhost:8000/api/appointments/{appointementId}/is-available     // check if appointment with id=? is available  
    * localhost:8000/api/appointments/{appointmentId}/mark-unavailable  //mark appointment as unavilable  (POST)
    * localhost:8000/api/doctors                         // return all doctors
    * localhost:8000/api/doctors                         //save doctor  (POST)
    * localhost:8001/api/patient-appointements/{patientId}/appointment/{appointementId}        //reserve appointment to                       patient (POST)
    * localhost:8001/api/patients/save                  // save patient (POST)          


