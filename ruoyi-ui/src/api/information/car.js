import request from '@/utils/request'

// 查询车辆参数列表
export function listCar(query) {
  return request({
    url: '/information/car/list',
    method: 'get',
    params: query
  })
}

// 查询车辆参数详细
export function getCar(id) {
  return request({
    url: '/information/car/' + id,
    method: 'get'
  })
}

// 新增车辆参数
export function addCar(data) {
  return request({
    url: '/information/car',
    method: 'post',
    data: data
  })
}

// 修改车辆参数
export function updateCar(data) {
  return request({
    url: '/information/car',
    method: 'put',
    data: data
  })
}

// 删除车辆参数
export function delCar(id) {
  return request({
    url: '/information/car/' + id,
    method: 'delete'
  })
}

// 导出车辆参数
export function exportCar(query) {
  return request({
    url: '/information/car/export',
    method: 'get',
    params: query
  })
}