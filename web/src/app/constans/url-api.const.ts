export const DOMAIN_SERVER = 'http://localhost:8090';

// api url public
export const PUBLIC_API = {
  LOGIN: `${DOMAIN_SERVER}/public/user/login`,
  LOAD_USER: `${DOMAIN_SERVER}/admin/user/get-user-refresh-app`
};

// api url admin
export const ADMIN_API = {
  LOGIN: `${DOMAIN_SERVER}/admin/user/login`,
  REGISTER: `${DOMAIN_SERVER}/admin/user/register`,
  LOGOUT: `${DOMAIN_SERVER}/admin/user/logout`,
  LOAD_USER: `${DOMAIN_SERVER}/admin/user/get-user-refresh-app`
};
