/* eslint no-undef: "off" */
import { createRouter, createWebHistory } from "vue-router";
import Dashboard from "../views/Dashboard.vue";
import Customers from "../views/Customers.vue";
import Instructors from "../views/Instructors.vue";

import Billing from "../views/Billing.vue";
import Profile from "../views/Profile.vue";
import Signup from "../views/Signup.vue";
import Signin from "../views/Signin.vue";
import Registrations from "../views/Registrations.vue";



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
    name: "customers",
    component: Customers,
  },
  {
    path: "/instructors",
    name: "instructors",
    component: Instructors,
  },
  {
    path: "/billing",
    name: "Billing",
    component: Billing,
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
  path: "/customer/registrations",
  name: "registrations",
  component: Registrations,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
  linkActiveClass: "active",
});

export default router;
