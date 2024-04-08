/* eslint no-undef: "off" */
import { createRouter, createWebHistory } from "vue-router";
<<<<<<< HEAD
import Dashboard from "../views/Dashboard.vue";
import Customers from "../views/Customers.vue";
import Instructors from "../views/Instructors.vue";

import Billing from "../views/Billing.vue";
import Profile from "../views/Profile.vue";
import Signup from "../views/Signup.vue";
import Signin from "../views/Signin.vue";
import Registrations from "../views/Registrations.vue";
import CourseTypes from "../views/CourseTypes.vue";
import ScheduledCourses from "../views/ScheduledCourses.vue";
import NotFoundPage from "../views/NotFoundPage.vue";
=======
import Dashboard from ".././components/Dashboard.vue";
import Customers from ".././components/Customers.vue";
import Instructors from ".././components/Instructors.vue";
>>>>>>> 0f84a4d293f21a5f5ab29d71faaa9d8718facd51

import Profile from ".././components/Profile.vue";
import Signup from ".././components/Signup.vue";
import Signin from ".././components/Signin.vue";
import Registrations from ".././components/Registrations.vue";
import CourseTypes from ".././components/CourseTypes.vue";
import ScheduledCourses from ".././components/ScheduledCourses.vue";
import CourseRegistration from ".././components/CourseRegistration.vue";
const routes = [
  {
    path: "/",
    name: "/",
    redirect: "/dashboard-default",
  },
  {
    path: "/dashboard-default",
    name: "Dashboard",
    component: Dashboard,
  },
  {
    path: "/customers",
    name: "Customers",
    component: Customers,
  },
  {
    path: "/instructors",
    name: "Instructors",
    component: Instructors,
  },
  {
    path: "/courseTypes",
    name: "Course Types",
    component: CourseTypes,
  },
  {
    path: "/scheduledCourses",
    name: "Scheduled courses",
    component: ScheduledCourses,
  },


  {
    path: "/profile",
    name: "Profile",
    component: Profile,
  },
  {
    path: "/signin",
    name: "Signin",
    component: Signin,
  },
  {
    path: "/signup",
    name: "Signup",
    component: Signup,
  },
  {
    path: "/courseregistration",
    name: "CourseRegistration",
    component: CourseRegistration,
  },
  {
  path: "/customer/registrations",
  name: "registrations",
  component: Registrations,
  },
  {
    path: "/:catchAll(.*)",
    name: "404NotFound",
    component: NotFoundPage,
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
  linkActiveClass: "active",
});

export default router;
