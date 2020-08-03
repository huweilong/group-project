import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/Index'
import NotFound from '../views/404'
import Register from '../views/user/Register'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/index'
  }, {
    path: '/index',
    name: 'index',
    component: Index
  }, {
    path: '/register',
    name: 'register',
    component: Register
  }, {
    path: '*',
    name: '404',
    component: NotFound
  }
]

const router = new VueRouter({
  routes
})

export default router
